#!/bin/bash

ADT_PATH="/Users/jhilton/flex_sdks/4.6.0-air3.6/bin/adt "
ANDROID_PLATFORM="-platform Android-ARM -C android . "
DEFAULT_PLATFORM=" "
IOS_PLATFORM="-platform iPhone-ARM -C ios . "
IOS_SIMULATOR="-platform iPhone-x86 -C iosSimulator . "
PACKAGE_TARGET="-package -target ane PackageManagerANE.ane extension.xml "
PLATFORM_OPTIONS="-platformoptions platformoptions.xml "
SWC="-swc ../as3/bin/PackageManagerANE.swc "

EXTENSION_BINARY="Release"
#EXTENSION_BINARY="Debug"

mkdir android
mkdir default
mkdir ios
mkdir iosSimulator

# copy the swc from the mobile live auth project
cp ../as3/bin/PackageManagerANE.swc PackageManagerANE.zip
unzip -o PackageManagerANE.zip

cp library.swf android/
cp library.swf default/
cp library.swf ios/
cp library.swf iosSimulator/

cp ../java/jar/PackageManagerANE.jar android/

# command to compile the ane
echo "running: "$ADT_PATH$PACKAGE_TARGET$SWC$ANDROID_PLATFORM$IOS_PLATFORM$PLATFORM_OPTIONS$IOS_SIMULATOR$DEFAULT_PLATFORM
$ADT_PATH$PACKAGE_TARGET$SWC$ANDROID_PLATFORM$IOS_PLATFORM$PLATFORM_OPTIONS$IOS_SIMULATOR$DEFAULT_PLATFORM

echo "cleaning up"

# cleanup
rm PackageManagerANE.zip
rm catalog.xml
rm library.swf

rm -rf android
rm -rf default
rm -rf ios
rm -rf iosSimulator

mv PackageManagerANE.ane ../ane/