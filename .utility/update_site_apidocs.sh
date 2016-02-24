#!/bin/bash
set -ev
if [ "$TRAVIS_JDK_VERSION" == "oraclejdk7" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

if [[ -z "$GH_TOKEN" ]]; then
echo -e "GH_TOKEN is not set"
exit 1
fi	
			
echo -e "Publishing javadoc to gh-pages . . .\n"

cp -R -v ./gwtbootstrap3/target/apidocs $HOME/javadoc-latest

git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"

# clone the gh-pages branch.
cd $HOME
rm -rf gh-pages
git clone --quiet --branch=gh-pages https://$GH_TOKEN@github.com/gwtbootstrap3/gwtbootstrap3-demo gh-pages > /dev/null
cd gh-pages

# remove the javadoc directories from git.
git rm -rf ./snapshot/apidocs

# copy the new javadoc to snapshot dir.
cp -Rf $HOME/javadoc-latest ./snapshot/apidocs

git add -f .
git commit -m "Auto-push javadoc to gh-pages successful. (Travis build: $TRAVIS_BUILD_NUMBER)"
git push -fq origin gh-pages

echo -e "Published javadoc to gh-pages.\n"
	
fi
