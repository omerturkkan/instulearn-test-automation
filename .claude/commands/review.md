---
description: Review the test code changed on this branch with the test-reviewer agent
allowed-tools: Bash(git diff:*), Bash(git status:*)
---

## Committed changes on this branch

!`git diff --name-only main...HEAD`

## Uncommitted changes

!`git status --short`

## Task

Use the test-reviewer agent to review the files listed above.
Send only test code: files under `src/test/` (Java and feature files). Skip all other files.
If there are no test files to review, say so and stop.
Show the agent's report as it is.
