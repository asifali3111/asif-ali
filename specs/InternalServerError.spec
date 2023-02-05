# Internal Server Error

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

## Internal Server Error is returned when hitting the /internal_server_error endpoint

* Post to the "internal_server_error" endpoint
* Then the response will be "Internal Server Error"
* The response code should be "500"

## Last updated timestamp returned in GET /last endpoint matches timestamp of the last POST to /internal_server_error
tags: last
* Post to the "internal_server_error" endpoint
* Then the response will be "Internal Server Error"
* Retrieve the last updated time from the "internal_server_error/last" endpoint
* Assert against last updated time
