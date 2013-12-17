[![Build Status](https://buildhive.cloudbees.com/job/gwtbootstrap3/job/gwtbootstrap3/badge/icon)](https://buildhive.cloudbees.com/job/gwtbootstrap3/job/gwtbootstrap3/)

GwtBootstrap3 is a GWT wrapper for Twitter's Bootstrap library version 3
containing design templates, styles and beautiful widgets.

Have a look at the [demo](http://gwtbootstrap3.github.io/gwtbootstrap3/) and its
[source code](https://github.com/gwtbootstrap3/gwtbootstrap3/tree/master/gwtbootstrap3-demo/src/main/java/com/svenjacobs/gwtbootstrap3/demo/client). Also use the [Google Group](https://groups.google.com/forum/?fromgroups#!forum/gwtbootstrap3) for help/discussion.

**Note:** This library is **not yet** feature complete. Patches / pull requests are welcome. See *Feature matrix* below.

# Usage

Add the dependency to your Maven POM:

```xml
<dependency>
    <groupId>org.gwtbootstrap3</groupId>
    <artifactId>gwtbootstrap3</artifactId>
    <version>0.4-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

or if you want to use the snapshot release:

```xml
<dependency>
    <groupId>org.gwtbootstrap3</groupId>
    <artifactId>gwtbootstrap3</artifactId>
    <version>0.4-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

In order to use snapshot releases you also need to add the Sonatype snapshots
repository to your POM:

```xml
<repositories>
    <repository>
        <id>sonatype-nexus-snapshots</id>
        <url>http://oss.sonatype.org/content/repositories/snapshots</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>
</repositories>
```

Inherit the GwtBootstrap3 module in your GWT module:

```xml
<module>
    <inherits name="org.gwtbootstrap3.GwtBootstrap3"/>
    ...
</module>
```

If you want to use the Bootstrap 2 "look-alike" theme inherit `GwtBootstrap3Theme`
instead of `GwtBootstrap3`.

Make sure to not inherit GWT's default styles or any other styles because
Bootstrap brings its own styles which are provided by the GwtBootstrap3 module.

Use the widgets in your UiBinder XML:

```xml
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
             xmlns:g="urn:import:com.google.gwt.user.client.ui"
             xmlns:b="urn:import:org.gwtbootstrap3.client.ui">

    <b:Container>
        <b:PageHeader>Yay buttons!</b:PageHeader>

        <b:Button>Some button</b:Button>
        <b:Button type="DANGER" size="LARGE">Dangerous button</b:Button>
    </b:Container>

</ui:UiBinder>
```

or create them in code if that's what you prefer.

**Tip:** GwtBootstrap3's styles and widgets, especially the fluid grid system,
work best when using the "classic" [panels](http://www.gwtproject.org/doc/latest/DevGuideUiPanels.html)
throughout your application and **not** the absolute positioned layout panels
introduced in GWT 2.0.

# Using a Custom Bootstrap Theme

If you want to use a Custom Bootstrap v3 Theme from websites like [wrapbootstrap](https://wrapbootstrap.com/) its super easy.

* Inherit GWTBootstrap3 module like normal
* Download the theme that you want (make sure that it is Twitter Bootstrap v3 compatible (** Will not work with Twitter Bootstrap v2.x.x themes **)
* Put the CSS files and any needed JS files into the public folder or create a resources folder for these files
* Link this file as "public" in your *.gwt.xml
* After the inhert of GWTBoostrap3 module, put stylesheet linkers for these CSS/JS files

With the inheritance of CSS, the stylesheet that was added last will be the priority. Hence this will override the default theme.

If you have any questions, please refer to the Google Group above.

```xml
<module>
    <inherits name="org.gwtbootstrap3.GwtBootstrap3"/>

    <public path='resource'>
        <include name='css/*.css'/>
        <include name='js/*.js'/>
    </public>

    <stylesheet src='css/theme.css'/>
    <script src='js/theme.js'/>
</module>
```

# Feature matrix

Following Bootstrap features are natively supported by GwtBootstrap3 through
widgets. Other Bootstrap features **still can be used** with plain HTML and
JavaScript, see Bootstrap's [documentation](http://getbootstrap.com/).

## CSS

| Feature     | Status              | In Demo    |
|-------------|---------------------|------------|
| Grid system | Supported           | Yes        |
| Typography  | Supported           | Yes        |
| Code        | Supported           | Yes        |
| Tables      | Not supported       | No         |
| Forms       | Supported           | Yes        |
| Buttons     | Supported           | Yes        |
| Images      | Supported           | Yes        |
| Responsive  | Supported           | Yes        |

## Components

| Feature                             | Status              | In Demo    |
|-------------------------------------|---------------------|------------|
| Icons (FontAwesome v4.0.3)          | Supported           | Yes        |
| Dropdowns                           | Supported           | Yes        |
| Button groups                       | Supported           | Yes        |
| Button dropdowns                    | Supported           | Yes        |
| Input groups                        | Supported           | Yes        |
| Navs                                | Supported           | Yes        |
| Navbar                              | Supported           | Yes        |
| Breadcrumbs                         | Supported           | Yes        |
| Pagination                          | Not supported       | No         |
| Labels                              | Supported           | Yes        |
| Badges                              | Supported           | Yes        |
| Jumbotron                           | Supported           | Yes        |
| Page Header                         | Supported           | Yes        |
| Thumbnails                          | Supported           | Yes        |
| Alerts                              | Supported           | Yes        |
| Progress bars                       | Supported           | Yes        |
| Media object                        | Not supported       | No         |
| List group                          | Supported           | Yes        |
| Panels                              | Supported           | Yes        |
| Wells                               | Supported           | Yes        |

## JavaScript

| Feature     | Status        | In Demo    |
|-------------|---------------|------------|
| Modal       | Supported     | No         |
| Scrollspy   | Supported     | No         |
| Tooltip     | Supported     | Yes        |
| Popover     | Supported     | Yes        |
| Collapse    | Not supported | No         |
| Carousel    | Supported     | Yes        |
| Affix       | Supported     | No         |

# Relationship between raw Bootstrap components and GWT widgets 

GwtBootstrap's widgets are designed to mimick the HTML structure of Bootstrap UI
elements as best as possible while not introducing another layer of abstraction.
While this might result in a bit more typing it also offers greater flexibility
and reusability of components. Thus it should be relatively easy to translate
Bootstrap's [HTML code](http://getbootstrap.com/components/) into UiBinder XML.

For example a button dropdown is implemented in UiBinder XML like:

```xml
<b:ButtonGroup>
    <b:Button toggle="DROPDOWN">Test</b:Button>
    <b:DropDownMenu>
        <b:ListItem>Item 1</b:ListItem>
        <b:ListItem>Item 2</b:ListItem>
        <b:ListItem>Item 3</b:ListItem>
        <b:Divider/>
        <b:ListItem>Item 4</b:ListItem>
    </b:DropDownMenu>
</b:ButtonGroup>
```

Compare this to the HTML version:

```html
<div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        Test <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">Item 1</a></li>
        <li><a href="#">Item 2</a></li>
        <li><a href="#">Item 3</a></li>
        <li class="divider"></li>
        <li><a href="#">Item 4</a></li>
    </ul>
</div>
```

# Acknowledgement

Huge thanks go to [Joshua Godi](https://github.com/jgodi) who added many missing components and reworked the library!
