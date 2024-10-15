#!/bin/bash

# Deletar todos os Services
kubectl delete services --all

# Deletar todos os Deployments
kubectl delete deployments --all

echo "Todos os Services e Deployments foram deletados."