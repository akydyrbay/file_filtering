#!/bin/bash

SRC_DIR="src/java"
OUT_DIR="out"
MAIN_CLASS="util.Main"
JAR_NAME="util.jar"
INPUT_ARGS="-s -a -p sample- in1.txt in2.txt"

echo "Cleaning previous build..."
rm -rf "$OUT_DIR" "$JAR_NAME"

echo "Compiling source files..."
mkdir -p "$OUT_DIR"
javac -d "$OUT_DIR" "$SRC_DIR"/util/*.java

echo "Packaging into $JAR_NAME..."
jar cfe "$JAR_NAME" "$MAIN_CLASS" -C "$OUT_DIR" .

echo "Ready for testing!"