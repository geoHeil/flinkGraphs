# flink starter

my first flink project to familiarize with flink and its capabilities.
I want to analyze some graphs with: https://github.com/dbs-leipzig/gradoop

## open questions
- how to get interactive development running. Executing

```
sbt console
```
and then pasting the code into the REPL
```
// get input data
  val text = env.fromElements(
    "To be, or not to be,--that is the question:--",
    "Whether 'tis nobler in the mind to suffer", "The slings and arrows of outrageous fortune",
    "Or to take arms against a sea of troubles,")

  val counts = text.flatMap {
    _.toLowerCase.split("\\W+")
  }
    .map {
      (_, 1)
    }
    .groupBy(0)
    .sum(1)

  // execute and print result
  counts.print()
```
will throw an error

- starting out with flink I want to learn about some best practices with flink (unit testing, integration testing) and would be looking forward to some input 