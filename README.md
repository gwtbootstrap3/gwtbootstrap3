GwtBootstrap3 is a GWT wrapper for Twitter's Bootstrap library version 3
containing design templates, styles and beautiful widgets.

Have a look at the [demo](http://svenjacobs.github.io/gwtbootstrap3/) and its
[source code](https://github.com/svenjacobs/gwtbootstrap3/tree/master/src/gwtbootstrap3-demo/src/main/java/com/svenjacobs/gwtbootstrap3/demo/client).

**Note:** This library is **not** feature complete as it contains only the
widgets / functionality that I needed for another project of mine.
Patches / pull requests are welcome. See *Feature matrix* below.

# Usage

Add the dependency to your Maven POM:

```xml
<dependency>
    <groupId>com.svenjacobs.gwtbootstrap3</groupId>
    <artifactId>gwtbootstrap3</artifactId>
    <version>0.1-SNAPSHOT</version>
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
    <inherits name="com.svenjacobs.gwtbootstrap3.GwtBootstrap3"/>
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
             xmlns:b="urn:import:com.svenjacobs.gwtbootstrap3.client.ui">

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
throughout your application and **not** the absolut positioned layout panels
introduced in GWT 2.0.

# Feature matrix

Following Bootstrap features are natively supported by GwtBootstrap3 through
widgets. Other Bootstrap features **still can be used** with plain HTML and
JavaScript, see Bootstrap's [documentation](http://getbootstrap.com/).

## CSS

| Feature     | Status              | In Demo    |
|-------------|---------------------|------------|
| Grid system | Supported           | In Progress|
| Typography  | Supported           | Yes        |
| Code        | Supported           | Yes        |
| Tables      | Not supported       | No         |
| Forms       | Supported           | Yes        |
| Buttons     | Supported           | Yes        |
| Images      | Supported           | No         |
| Responsive  | Supported           | In Progress|

## Components

| Feature                             | Status              | In Demo    |
|-------------------------------------|---------------------|------------|
| Icons (FontAwesome)                 | Supported           | No         |
| Dropdowns                           | Supported           | No         |
| Button groups                       | Supported           | No         |
| Button dropdowns                    | Supported           | No         |
| Input groups                        | Partially supported | No         |
| Navs                                | Supported           | No         |
| Navbar                              | Supported           | No         |
| Breadcrumbs                         | Supported           | No         |
| Pagination                          | Not supported       | No         |
| Labels                              | Supported           | No         |
| Badges                              | Supported           | No         |
| Jumbotron                           | Supported           | No         |
| Page Header                         | Supported           | No         |
| Thumbnails                          | Not supported       | No         |
| Alerts                              | Supported           | No         |
| Progress bars                       | Supported           | No         |
| Media object                        | Not supported       | No         |
| List group                          | Supported           | Yes        |
| Panels                              | Supported           | No         |
| Wells                               | Supported           | No         |

## JavaScript

| Feature     | Status        | In Demo    |
|-------------|---------------|------------|
| Transitions | Not supported | No         |
| Modal       | Supported     | No         |
| Dropdown    | Supported     | No         |
| Scrollspy   | Supported     | No         |
| Tab         | Not supported | No         |
| Tooltip     | Not supported | No         |
| Popover     | Not supported | No         |
| Alert       | Supported     | No         |
| Button      | Supported     | No         |
| Collapse    | Not supported | No         |
| Carousel    | Not supported | No         |
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
