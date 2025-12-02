# 79_springbootandmicroservices

# payload for user with associations.
```
{
    "name": "vivek",
    "contact": "vivek@gmail.com",
    "address": {
        "city": "HYD",
        "state": "TG",
        "zip": 50081
    },
    "hobbie": [
        {
            "name": "cricket",
            "type": "outdoor"
        },
        {
            "name": "reading",
            "type": "none"
        }
    ],
    "cources": [
        {
            "name": "java_fullstack"
        },
        {
            "name": "devops"
        }
    ]
}

```

# swagger url
http://localhost:8080/swagger-ui/index.html#/

# Zipkin Jar Download URL
https://repo1.maven.org/maven2/io/zipkin/java/zipkin-server/2.12.9/

Get zipkin-server-2.12.9-exec.jar