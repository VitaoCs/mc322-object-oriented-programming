#!/usr/bin/env python
"""Django's command-line utility for administrative tasks."""
import os
import sys, pdb
from django.http import JsonResponse
from django.shortcuts import render

def main():
    """Run administrative tasks."""
    os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'framework.settings')
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    execute_from_command_line(sys.argv)


def home(request):
    lista_de_grupos = os.listdir('dataBase/grupos')

    context = {'lista_de_grupos': lista_de_grupos}


    return render(request, 'tela.html', context=context)



def busca_mensagens(request):

    nome_do_grupo = request.GET['nome_do_grupo']

    if (nome_do_grupo == '1'):
        matriz=[['JadeAlice123', 'Não tinha medo o tal João de Santo Cristo', 'Enviado: Thu Jan 21 19:43:00 BRT 2021'],
                ['VitaoCs','Era o que todos diziam quando ele se perdeu, Deixou pra trás todo o marasmo da fazenda', 'Enviado: Thu Jan 21 19:43:00 BRT 2021'],
                ['JadeAlice123', 'Só pra sentir no seu sangue o ódio que Jesus lhe deu', 'Enviado: Thu Jan 21 19:43:00 BRT 2021']]

    if (nome_do_grupo == '2'):
        matriz=[['VitaoCs', 'Quando criança só pensava em ser bandido, Ainda mais quando com um tiro de soldado o pai morreu', 'Enviado: Thu Jan 21 19:43:00 BRT 2021'],
                ['PaolaHarduim', 'Era o terror da sertania onde morava', 'Enviado: Thu Jan 21 19:43:00 BRT 2021'],
                ['JadeAlice123', 'E na escola até o professor com ele aprendeu', 'Enviado: Thu Jan 21 19:43:00 BRT 2021'],
                ['Ju_Viana', 'Ia pra igreja só pra roubar o dinheiro', 'Enviado: Thu Jan 21 19:43:00 BRT 2021']]



    return JsonResponse({'matriz': matriz})