#!/bin/bash

# Build Docker image
docker build -t digidine:latest .

# Start Minikube and configure Docker environment
minikube start
eval $(minikube docker-env)

# Apply all YAML files
for file in *.yaml; do
  echo "Applying $file..."
  kubectl apply -f "$file"
done

# Start Minikube services
minikube service mongo digidine-service mongo-express-service
