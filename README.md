# To run
```bash
mvn package
java -jar servicepartnerone-1.0-SNAPSHOT.jar
```

# To use optimizer endpoint
## Example:
curl -X POST \
  http://localhost:8080/optimizer \
  -H 'Content-Type: application/json' \
  -d '{
    "rooms": [
        24,
        28
    ],
    "senior": 11,
    "junior": 6
}'
