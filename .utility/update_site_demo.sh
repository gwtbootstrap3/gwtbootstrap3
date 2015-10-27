#!/bin/bash
set -ev
if [ "$TRAVIS_JDK_VERSION" == "oraclejdk7" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

if [[ -z "$GH_TOKEN" ]]; then
echo -e "GH_TOKEN is not set"
exit 1
fi	
			
echo -e "Publishing demo to gh-pages . . .\n"

git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"

# clone and build the demo application.
cd $HOME
git clone --quiet --branch=master https://$GH_TOKEN@github.com/gwtbootstrap3/gwtbootstrap3-demo demo > /dev/null
cd demo
mvn clean package || { echo -e "gwtbootstrap3-demo build failed" ; exit 1; }

# check to make sure the demo war file is present.
if ![[ -f $HOME/demo/target/gwtbootstrap3-demo-*.war ]]; then
echo -e "gwtbootstrap3-demo war file not found."
exit 1
fi	

# clone the gh-pages branch.
cd $HOME
git clone --quiet --branch=gh-pages https://$GH_TOKEN@github.com/gwtbootstrap3/gwtbootstrap3-demo gh-pages > /dev/null
cd gh-pages

# remove the GwtBootstrap3Demo directories from git.
git rm -rf ./snapshot/GwtBootstrap3Demo
git rm -rf ./snapshot/GwtBootstrap3Demo.html
git rm -rf ./snapshot/images
git rm -rf ./snapshot/META-INF
git rm -rf ./snapshot/WEB-INF

# copy the new GwtBootstrap3Demo the snapshot dir.
unzip -u $HOME/demo/target/gwtbootstrap3-demo-*.war -d ./snapshot/
mv -f  ./snapshot/GwtBootstrap3Demo.html ./snapshot/index.html
rm -rf ./snapshot/META-INF 
rm -rf ./snapshot/WEB-INF

git add -f .
git commit -m "Auto-push demo to gh-pages successful. (Travis build: $TRAVIS_BUILD_NUMBER)"
git push -fq origin gh-pages > /dev/null

echo -e "Published demo to gh-pages.\n"
	
fi
