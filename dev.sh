#!/bin/bash

# Caminhos dos projetos
FRONTEND="/run/media/hiago/MeusArquivos/ProjetosDev/appfrete/front_appfrete"
BACKEND="/mnt/ProjetosDev/manutencao_erp/manutencao_erp/"

# Abrir o frontend em uma nova aba
#gnome-terminal --tab -- bash -c "cd '$FRONTEND' && code . && exec bash"

# Abrir o backend em uma nova aba
gnome-terminal --tab -- bash -c "cd '$BACKEND' && intellij-idea-community . && exec bash"


echo "Projetos abertos no intellij!"
