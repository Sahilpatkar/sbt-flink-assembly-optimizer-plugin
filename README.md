# sbt-flink-assembly-optimizer-plugin

An SBT plugin for optimizing Apache Flink JAR assemblies, built on top of the popular `sbt-assembly` plugin, specifically designed to streamline the merging process and reduce the size of JAR files. This plugin handles common assembly issues, such as merge conflicts and dependency pruning, to improve the efficiency and deployment of Flink applications.


## Features:

- #### **Optimized Assembly Merging**: Automatically manages dependency conflicts that typically occur when using sbt assembly in large projects.

- #### **Flink-Ready JARs**: Produces minimized JAR files optimized for deployment in Apache Flink environments.


## Prerequisites
- SBT 1.0 or later
- Scala 2.12 +
- Java JDK 8 or later


## USAGE
This plugin is hosted on GitHub Packages, so you’ll need to add it as a resolver in your SBT project.

1. Add GitHub Packages as a Resolver

    In your project’s `project/plugins.sbt`, add the following resolver along with the plugin dependency:
    ```
    resolvers += "GitHub Packages" at "https://maven.pkg.github.com/Sahilpatkar/sbt-flink-assembly-optimizer-plugin"
    
    addSbtPlugin("com.sp" % "sbt-flink-assembly-optimizer-plugin" % "0.2-SNAPSHOT")
    ```
2. Configure Credentials

    GitHub Packages requires authentication to download packages. You can authenticate using a Personal Access Token (PAT) or by using GitHub Actions for CI/CD.

#### Using a Personal Access Token (PAT) Locally
If you’re working locally, follow these steps to set up credentials:

1. Generate a PAT:

    - Go to Settings > Developer settings > Personal access tokens in GitHub.
    - Generate a token with read:packages (for public repositories) or read:packages and repo (for private repositories).

2. Add Credentials to SBT:

    - Create or edit ~/.sbt/1.0/global.sbt with the following configuration:
    ```
    credentials += Credentials(
      "GitHub Package Registry",
      "maven.pkg.github.com",
      "yourusername",
      "your_personal_access_token"
    )
    ```
   
Using GITHUB_TOKEN in GitHub Actions

If you’re using this plugin in a GitHub Actions workflow, you can use the automatically generated GITHUB_TOKEN to authenticate with GitHub Packages. Here’s an example workflow:   
```yaml
    name: Configure GitHub Credentials
    env:
      GITHUB_ACTOR: ${{ github.actor }}
      GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
    run: |
      echo "credentials += Credentials(\"GitHub Package Registry\", \"maven.pkg.github.com\", \"$GITHUB_ACTOR\", \"$GITHUB_TOKEN\")" >> ~/.sbt/1.0/global.sbt
```


After adding the plugin to `plugins.sbt` and configuring credentials 
you can use `sbt assembly` to create an optimised uber jar of your flink project.
