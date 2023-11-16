# Task02
Objective: After receiving a list of items from server, process and make purchase decisions based on multiple criteria such as price, ratings and budget, then respond back to the server with a list of items to purchase.

# Run Instructions
## Compile
`javac -d task02/classes task02/src/*.java`
## Run Client
`java -cp task02/classes Client`

or

`java -cp task02/classes Client <Port>`

or

`java -cp task02/classes Client <Host> <Port>`

## Run Server
`java -jar task02-server.jar`

or

`java -jar task02-server.jar <Port>`

# Expected Output
```
Connected to server
Completed parsing information from server.
Generating response for server....
Sending response to server..
success
```