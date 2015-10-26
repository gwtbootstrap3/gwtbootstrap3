#!/bin/bash
set -ev
if [ "$TRAVIS_JDK_VERSION" == "oraclejdk7" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
	
echo -e "Publishing snapshot demo app and javadoc . . .\n"

cp -R ./gwtbootstrap3/target/javadoc $HOME/javadoc-latest

git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"

# clone and build the demo application.
cd $HOME
git clone --quiet --branch=master https://${GH_TOKEN}@github.com/gwtbootstrap3/gwtbootstrap3-demo demo > /dev/null
cd demo
mvn clean package

# clone the gh-pages branch.
cd $HOME
git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/gwtbootstrap3/gwtbootstrap3-demo gh-pages > /dev/null
cd gh-pages

# remove the GwtBootstrap3Demo and apidocs directories from git.
git rm -rf ./snapshot/GwtBootstrap3Demo
git rm -rf ./snapshot/images
git rm -rf ./snapshot/apidocs

# copy the new GwtBootstrap3Demo and apidocsto the snapshot dir.q
cp -Rf $HOME/javadoc-latest ./snapshot/apidocs
unzip -u $HOME/demo/target/gwtbootstrap3-demo-*.war -d ./snapshot/

git add -f .
git commit -m "Lastest javadoc and demo app on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
git push -fq origin gh-pages > /dev/null

echo -e "Published Javadoc and demo application to gh-pages.\n"
	
fi
