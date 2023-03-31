# Sorted linked list example

### Prerequisities
- JDK 8
- Gradle 7

### Run
```sh
./gradlew bootRun
```
Starts at http://localhost:8083.

### Test
```sh
./gradlew test
```

### Usage
Add to int list
```sh
curl -X POST localhost:8083/int -H 'Content-type:application/json' -d '42'
curl -X POST localhost:8083/int -H 'Content-type:application/json' -d '38'
```
Get i-th item from string list
```sh
curl -X GET localhost:8083/int/<i>
```
Remove i-th item from string list
```sh
curl -X DELETE localhost:8083/int/<i>
```
Add to string list
```sh
curl -X POST localhost:8083/string -H 'Content-type:application/json' -d 'foo'
curl -X POST localhost:8083/string -H 'Content-type:application/json' -d 'bar'
```
Get i-th item from string list
```sh
curl -X GET localhost:8083/string/<i>
```
Remove i-th item from string list
```sh
curl -X DELETE localhost:8083/string/<i>
```

### Warning
Not user friendly. Casting, index out of bounds, etc. exceptions not handled. No user input validation.
