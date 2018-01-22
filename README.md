# Yahoo Weather API
* Using [Yahoo's Weather API](https://developer.yahoo.com/weather/#js), create a REST resource which displays information about the current weather in the area.
* The information should be updated every 5 minutes.
* Ensure that your proejct architecture is as clean as possible
    * **Note:**
        * `Repository` implements [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) functionality.
        * `Service` implements business logic by manipulating a composite `Repository`
        * `Controller` hosts client-accessible [End Points](https://stackoverflow.com/questions/10799198/what-are-rest-resources)
        * `Domain` or `Model` are object-representations of our data 