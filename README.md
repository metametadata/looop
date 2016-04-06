This project demonstrates the issue with using Reagent's run! for listening to the part of app state.
See discussion at https://groups.google.com/forum/#!topic/reagent-project/8yFATqOMB7U

To run in browser: `lein figwheel`, then open http://localhost:3449/ and see console logs.
On my machine in Chrome they look like this:

```
subscribe to :this
  do side effect with 2
    update :that
update :that
  do side effect with 4
    update :that
```

P.S. There is a lot of unused code and deps because I didn't bother to clean it after creating the project from reagent project template.