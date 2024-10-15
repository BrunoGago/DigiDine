#!/bin/bash

# Aplica todos os arquivos YAML no diretório atual
for file in *.yaml; do
  echo "Applying $file..."
  kubectl apply -f "$file"
done
