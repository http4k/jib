# Containerize an [http4k](http://http4k.org/) app with Jib

This is an example of how to easily build a Docker image for an [http4k] application written in pure Kotlin with Jib.

## Quickstart

### With Docker

Build it:
```shell
./gradlew jibDockerBuild
```

Run it:
```shell
docker run -d -p 8080:8080 http4k/http4k-jib
```

Test it:
```shell
curl localhost:8080
> 🥳 Hello World 🥳
```

### With Kubernetes

Build it:
```shell
./gradlew jib
```

Run it:
```shell
kubectl run http4k-jib --image=http4k/http4k-jib --port=8080 --restart=Never

# Wait until pod is running
kubectl port-forward http4k-jib 8080 > /dev/null 2>&1 &

Test it:
```shell
curl localhost:8080
> 🥳 Hello World 🥳
```

## More information

Learn [more about Jib](https://github.com/GoogleContainerTools/jib).
Learn [more about http4k](https://http4k.org).

[http4k](http://http4k.org/)