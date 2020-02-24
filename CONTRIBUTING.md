# Contributing to 7Facette

:+1::tada: First off, thanks for taking the time to contribute! :tada::+1:

The following is a set of guidelines for contributing to 7Facette and its packages, which are hosted on GitHub. These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

#### Table Of Contents

- [Code of Conduct](#code-of-conduct)
  - [I don't want to read this whole thing I just have a question!!!](#i-dont-want-to-read-this-whole-thing-i-just-have-a-question)
  - [What should I know before I get started?](#what-should-i-know-before-i-get-started)
    - [7Facette and Modules](#7facette-and-modules)
      - [Module Conventions](#module-conventions)
    - [Design Decisions](#design-decisions)
  - [How Can I Contribute?](#how-can-i-contribute)
    - [Reporting Bugs](#reporting-bugs)
      - [Before Submitting A Bug Report](#before-submitting-a-bug-report)
      - [How Do I Submit A (Good) Bug Report?](#how-do-i-submit-a-good-bug-report)
    - [Suggesting Enhancements](#suggesting-enhancements)
      - [Before Submitting An Enhancement Suggestion](#before-submitting-an-enhancement-suggestion)
      - [How Do I Submit A (Good) Enhancement Suggestion?](#how-do-i-submit-a-good-enhancement-suggestion)
    - [Your First Code Contribution](#your-first-code-contribution)
      - [Local development](#local-development)
    - [Pull Requests](#pull-requests)
  - [Styleguides](#styleguides)
    - [Git Commit Messages](#git-commit-messages)
    - [Kotlin Styleguide](#kotlin-styleguide)
    - [Test Styleguide](#test-styleguide)
      - [Example](#example)
    - [Documentation Styleguide](#documentation-styleguide)
      - [Example](#example-1)
  - [Additional Notes](#additional-notes)
    - [Issue Labels](#issue-labels)
      - [Type of Issue and Issue State](#type-of-issue-and-issue-state)

## Code of Conduct

This project and everyone participating in it is governed by the [7Facette Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. 

## I don't want to read this whole thing I just have a question!!!

> **Note:** Please don't file an issue to ask a question. You'll get faster results by using the resources below.

## What should I know before I get started?

### 7Facette and Modules

7Facette is an open source project &mdash; setted up as a multiplatform project. When you initially consider contributing to 7Facette, you might be unsure about which of those modules implements the functionality you want to change or report a bug for. This section should help you with that.

7Facette is intentionally very modular. Here's a list of our actual modules:

* [7Facette/core](https://github.com/7Facette/core) - 7Facette Core! The core component is responsible for . 
* [7Facette/web](https://github.com/7Facette/) - the web testing package with selenium.

This list should be a good starting point. For more information on how to work with 7Facette's official packages, see [Contributing to 7Facette Packages][contributing-to-official-7Facette-packages].

#### Module Conventions

There are a few conventions that have developed over time around modules:

* Modules are split by domains. 
    * Domains are named `sevenfacette/[domain]`

### Design Decisions

When we make a significant decision in how we maintain the project and what we can or cannot support, we will document it on [Discuss, the official 7Facette message board](https://discuss.7Facette.io). If you have a question around how we do things, check to see if it is documented there. If it is *not* documented there, please open a new discussion on the board and ask your question.

## How Can I Contribute?

### Reporting Bugs

This section guides you through submitting a bug report for 7Facette. Following these guidelines helps maintainers and the community understand your report :pencil:, reproduce the behavior :computer: :computer:, and find related reports :mag_right:.

Before creating bug reports, please check [this list](#before-submitting-a-bug-report) as you might find out that you don't need to create one. When you are creating a bug report, please [include as many details as possible](#how-do-i-submit-a-good-bug-report). Fill out [the required template](/ISSUE_TEMPLATE/bug_report.md), the information it asks for helps us resolve issues faster.

> **Note:** If you find a **Closed** issue that seems like it is the same thing that you're experiencing, open a new issue and include a link to the original issue in the body of your new one.

#### Before Submitting A Bug Report

* **Check the [debugging guide](https://7Facette/debugging/ NOTWENDIG?).** You might be able to find the cause of the problem and fix things yourself. Most importantly, check if you can reproduce the problem [in the latest version of 7Facette](), if the problem happens when you run 7Facette, and if you can get the desired behavior by changing [7Facette packages or config settings]().
* **Check the [FAQs on the forum](https://discuss.7Facette.io/c/faq)** for a list of common questions and problems.
* **Determine [which module the problem should be reported in](#7Facette-and-packages)**.
* **Perform a [cursory search]()** to see if the problem has already been reported. If it has **and the issue is still open**, add a comment to the existing issue instead of opening a new one.

#### How Do I Submit A (Good) Bug Report?

Bugs are tracked as [GitHub issues](https://guides.github.com/features/issues/). After you've determined [which module](#7Facette-and-packages) your bug is related to, create an issue on the repository and provide the following information by filling in [the template](/ISSUE_TEMPLATE/bug_report.md).

Explain the problem and include additional details to help maintainers reproduce the problem:

* **Use a clear and descriptive title** for the issue to identify the problem.
* **Describe the exact steps which reproduce the problem** in as many details as possible. For example, start by explaining how you started 7Facette, e.g. which command exactly you used in the terminal, or how you started 7Facette otherwise. When listing steps, **don't just say what you did, but explain how you did it**. For example, if you used the gradle wrapper to run your tests, explain which version, or which command, and so on.
* **Provide specific examples to demonstrate the steps**. Include links to files or GitHub projects, or copy/pasteable snippets, which you use in those examples. If you're providing snippets in the issue, use [Markdown code blocks](https://help.github.com/articles/markdown-basics/#multiple-lines).
* **Describe the behavior you observed after following the steps** and point out what exactly is the problem with that behavior.
* **Explain which behavior you expected to see instead and why.**
* **Include screenshots and animated GIFs** which show you following the described steps and clearly demonstrate the problem. 
* **If you're reporting that 7Facette crashed**, include a crash report with a stack trace. Include the crash report in the issue in a [code block](https://help.github.com/articles/markdown-basics/#multiple-lines), a [file attachment](https://help.github.com/articles/file-attachments-on-issues-and-pull-requests/), or put it in a [gist](https://gist.github.com/) and provide link to that gist.
* **If the problem is related to performance or memory**, include a CPU profile capture with your report
* **If the problem wasn't triggered by a specific action**, describe what you were doing before the problem happened and share more information using the guidelines below.

Provide more context by answering these questions:

* **Can you reproduce the problem?**
* **Did the problem start happening recently** (e.g. after updating to a new version of 7Facette) or was this always a problem?
* If the problem started happening recently, **can you reproduce the problem in an older version of **7Facette**?** What's the most recent version in which the problem doesn't happen? You can download older versions of 7Facette from [the releases page](https://github.com/7Facette/releases).
* **Can you reliably reproduce the issue?** If not, provide details about how often the problem happens and under which conditions it normally happens.
* If the problem is related to working with files (e.g. opening and editing files), **does the problem happen for all files and projects or only some?** Does the problem happen only when working with local or remote files (e.g. on network drives), with files of a specific type (e.g. only Json or XML files), with large files or files with very long lines, or with files in a specific encoding? Is there anything else special about the files you are using?

Include details about your configuration and environment:

* **Which version of 7Facette are you using?** You can get the exact version from your gradle build, or maven pom.
* **What's the name and version of the OS you're using**?
* **What's the kotlin, java or node js version you're using**?
* **Which [modules](#facette-and-packages) are you using?** 
* **Are you using environment variables or files** `config.env` to configure 7Facette? If so, provide the contents of those files, preferably in a [code block](https://help.github.com/articles/markdown-basics/#multiple-lines) or with a link to a [gist](https://gist.github.com/).

### Suggesting Enhancements

This section guides you through submitting an enhancement suggestion for 7Facette, including completely new features and minor improvements to existing functionality. Following these guidelines helps maintainers and the community understand your suggestion :pencil: and find related suggestions :mag_right:.

Before creating enhancement suggestions, please check [this list](#before-submitting-an-enhancement-suggestion) as you might find out that you don't need to create one. When you are creating an enhancement suggestion, please [include as many details as possible](#how-do-i-submit-a-good-enhancement-suggestion). Fill in [the template](https://github.com/facette/.github/blob/master/.github/ISSUE_TEMPLATE/feature_request.md), including the steps that you imagine you would take if the feature you're requesting existed.

#### Before Submitting An Enhancement Suggestion

* **Check the [Wiki](https://flight-manual.7Facette.io/hacking-7Facette/sections/debugging/)** for tips — you might discover that the enhancement is already available. Most importantly, check if you're using [the latest version of 7Facette](https://flight-manual.7Facette.io/hacking-7Facette/sections/debugging/#update-to-the-latest-version).
* **Check if there's already [a module](https://7Facette.io/packages) which provides that enhancement.**
* **Determine [which module the enhancement should be suggested in](#7Facette-and-packages).**
* **Perform a [cursory search](https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen&type=Issues)** to see if the enhancement has already been suggested. If it has, add a comment to the existing issue instead of opening a new one.

#### How Do I Submit A (Good) Enhancement Suggestion?

Enhancement suggestions are tracked as [GitHub issues](https://guides.github.com/features/issues/). After you've determined [which module](#7Facette-and-modules) your enhancement suggestion is related to, create an issue on the repository and provide the following information:

* **Use a clear and descriptive title** for the issue to identify the suggestion.
* **Provide a step-by-step description of the suggested enhancement** in as many details as possible.
* **Provide specific examples to demonstrate the steps**. Include copy/pasteable snippets which you use in those examples, as [Markdown code blocks](https://help.github.com/articles/markdown-basics/#multiple-lines).
* **Describe the current behavior** and **explain which behavior you expected to see instead** and why.
* **Explain why this enhancement would be useful** to most 7Facette users.
* **List some other automation libraries where this enhancement exists.**
* **Specify which version of 7Facette you're using.** You can get the exact version from your gradle build, or maven pom..
* **Specify the name and version of the OS you're using.**

### Your First Code Contribution

Unsure where to begin contributing to 7Facette? You can start by looking through these `beginner` and `help-wanted` issues:

* [Beginner issues][search-7Facette-repo-label-beginner] - issues which should only require a few lines of code, and a test or two.
* [Help wanted issues][search-7Facette-repo-label-help-wanted] - issues which should be a bit more involved than `beginner` issues.

Both issue lists are sorted by total number of comments. While not perfect, number of comments is a reasonable proxy for impact a given change will have.

#### Local development

7Facette core and all other modules can be developed locally. For instructions on how to do this, see the following sections in the [7Facette Wiki Local Development](https://flight-manual.7Facette.io)

### Pull Requests

The process described here has several goals:

- Maintain 7Facette's quality
- Fix problems that are important to users
- Engage the community in working toward the best possible 7Facette
- Enable a sustainable system for 7Facette's maintainers to review contributions

Please follow these steps to have your contribution considered by the maintainers:

1. Follow all instructions in [the template](/misc/templates/PULL_REQUEST_TEMPLATE/)
2. Follow the [styleguides](#styleguides)
3. After you submit your pull request, verify that all [status checks](https://help.github.com/articles/about-status-checks/) are passing <details><summary>What if the status checks are failing?</summary>If a status check is failing, and you believe that the failure is unrelated to your change, please leave a comment on the pull request explaining why you believe the failure is unrelated. A maintainer will re-run the status check for you. If we conclude that the failure was a false positive, then we will open an issue to track that problem with our status check suite.</details>

While the prerequisites above must be satisfied prior to having your pull request reviewed, the reviewer(s) may ask you to complete additional design work, tests, or other changes before your pull request can be ultimately accepted.

## Styleguides

### Git Commit Messages

* Use the present tense ("Add feature" not "Added feature")
* Use the imperative mood ("Move file to..." not "Moves file to...")
* Limit the first line to 72 characters or less
* Reference issues and pull requests liberally after the first line
* When only changing documentation, include `[ci skip]` in the commit title
* Consider starting the commit message with an applicable emoji:
    * :art: `:art:` when improving the format/structure of the code
    * :racehorse: `:racehorse:` when improving performance
    * :non-potable_water: `:non-potable_water:` when plugging memory leaks
    * :memo: `:memo:` when writing docs
    * :bug: `:bug:` when fixing a bug
    * :fire: `:fire:` when removing code or files
    * :green_heart: `:green_heart:` when fixing the CI build
    * :white_check_mark: `:white_check_mark:` when adding tests
    * :arrow_up: `:arrow_up:` when upgrading dependencies
    * :arrow_down: `:arrow_down:` when downgrading dependencies
    * :shirt: `:shirt:` when removing warnings

### Kotlin Styleguide

All Java code must adhere to [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

### Test Styleguide

- Include thoughtfully-worded, well-structured [JUnit](https://junit.org/) tests in the `./test` folder.

#### Example

```coffee
describe 'a dog', ->
 it 'barks', ->
 # spec here
 describe 'when the dog is happy', ->
  it 'wags its tail', ->
  # spec here
```

### Documentation Styleguide

* Use [Java Doc](https://daringfireball.net/projects/markdown).
* Reference methods and classes in markdown with the custom `{}` notation:
    * Reference classes with `{ClassName}`
    * Reference instance methods with `{ClassName::methodName}`
    * Reference class methods with `{ClassName.methodName}`

#### Example

```coffee
# Public: Disable the package with the given name.
#
# * `name`    The {String} name of the package to disable.
# * `options` (optional) The {Object} with disable options (default: {}):
#   * `trackTime`     A {Boolean}, `true` to track the amount of time taken.
#   * `ignoreErrors`  A {Boolean}, `true` to catch and ignore errors thrown.
# * `callback` The {Function} to call after the package has been disabled.
#
# Returns `undefined`.
disablePackage: (name, options, callback) ->
```

## Additional Notes

### Issue Labels

This section lists the labels we use to help us track and manage issues and pull requests. Most labels are used across all 7Facette modules.

[GitHub search](https://help.github.com/articles/searching-issues/) makes it easy to use labels for finding groups of issues or pull requests you're interested in. To help you find issues and pull requests, each label is listed with search links for finding open items with that label in `7Facette` only. We encourage you to read about [other search filters](https://help.github.com/articles/searching-issues/) which will help you write more focused queries.

Please open an issue on `7Facette` if you have suggestions for new labels, and if you notice some labels are missing.

#### Type of Issue and Issue State

| Label name | `7Facette` :mag_right: | Description |
| --- | --- | --- |
| `enhancement` | [search][search-7Facette-repo-label-enhancement] | Feature request |
| `bug` | [search][search-7Facette-repo-label-bug] | Confirmed bugs or reports that are very likely to be bugs |
| `question` | [search][search-7Facette-repo-label-question] | Questions more than bug reports or feature requests (e.g. how do I do X) |
| `help-wanted` | [search][search-7Facette-repo-label-help-wanted] | The 7Facette core team would appreciate help from the community in resolving these issues |
| `beginner` | [search][search-7Facette-repo-label-beginner] | Less complex issues which would be good first issues to work on for users who want to contribute to 7Facette |
| `duplicate` | [search][search-7Facette-repo-label-duplicate] | Issues which are duplicates of other issues, i.e. they have been reported before |
| `wontfix` | [search][search-7Facette-repo-label-wontfix] | The 7Facette core team has decided not to fix these issues for now, either because they're working as intended or for some other reason |
| `invalid` | [search][search-7Facette-repo-label-invalid] | Issues which aren't valid (e.g. user errors) |
| `documentation` | [search][search-7Facette-repo-label-invalid] | Related to any type of documentation (e.g. [Wiki](https://7Facette.io/docs/api/latest/)) |


[search-7Facette-repo-label-enhancement]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Aenhancement&type=Issues
[search-7Facette-repo-label-bug]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Abug&type=Issues
[search-7Facette-repo-label-question]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Aquestion&type=Issues
[search-7Facette-repo-label-help-wanted]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Ahelp-wanted&type=Issues
[search-7Facette-repo-label-beginner]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Abeginner&type=Issues
[search-7Facette-repo-label-duplicate]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Aduplicate&type=Issues
[search-7Facette-repo-label-wontfix]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Awontfix&type=Issues
[search-7Facette-repo-label-invalid]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Ainvalid&type=Issues
[search-7Facette-repo-label-documentation]: https://github.com/p7s1-ctf/SevenFacette/search?q=is%3Aissue+is%3Aopen+label%3Adocumentation&type=Issues