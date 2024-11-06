#!/bin/bash

# Set variables for dynamic paths
TEST_DIR="src/sbt-test/sbt-flink-assembly-merge-plugin/simple"
JAR_PATH="target/scala-2.12/test-project-assembly-0.1.jar"

pwd

# Navigate to the test project directory
cd "$TEST_DIR" || { echo "Failed to navigate to test directory"; exit 1; }

pwd

# Run SBT clean and assembly commands
echo "Running sbt clean assembly..."
sbt clean assembly || { echo "sbt assembly failed"; exit 1; }

# Check if the JAR file was created
if [[ -f "$JAR_PATH" ]]; then
  echo "Test passed: JAR file created successfully at $JAR_PATH"
  echo "Test completed, removing temp JAR."
  rm "$JAR_PATH"
else
  echo "Test failed: JAR file was not created."
  exit 1
fi

echo "Test completed successfully"
