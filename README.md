This Java app is used for trying out [Guava's Stats](https://google.github.io/guava/releases/23.0/api/docs/com/google/common/math/Stats.html) capabilities.

## Running

```bash
mvn compile exec:java -Dexec.mainClass=me.itzg.tryguavastats.FindOutliers -Dexec.args="5 8 2 5 4 6 3 6 7 12 1 5 4 6"
```