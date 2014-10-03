#!/bin/bash

ADT_PATH="/Users/jhilton/flex_sdks/4.6.0-air3.6/bin/adt "
PACKAGE_TARGET="-package -target ane PackageManagerANE.ane extension.xml "
SWC="-swc ../as3/bin/PackageManagerANE.swc "
ANDROID_PLATFORM="-platform Android-ARM -C android . "
DEFAULT_PLATFORM=" "

EXTENSION_BINARY="Release"
#EXTENSION_BINARY="Debug"

mkdir default
mkdir android

# copy the swc from the mobile live auth project
cp ../as3/bin/PackageManagerANE.swc PackageManagerANE.zip
unzip -o PackageManagerANE.zip

cp library.swf default/ 
cp library.swf android/

cp ../java/jar/PackageManagerANE.jar android/

# command to compile the ane
echo "running: "$ADT_PATH$PACKAGE_TARGET$SWC$ANDROID_PLATFORM$DEFAULT_PLATFORM
$ADT_PATH$PACKAGE_TARGET$SWC$ANDROID_PLATFORM$DEFAULT_PLATFORM

echo "cleaning up"

# cleanup
rm PackageManagerANE.zip
rm catalog.xml
rm library.swf

rm -rf default
rm -rf android

mv PackageManagerANE.ane ../ane/