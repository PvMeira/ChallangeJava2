# ChallangeJava2
Trabalho solicitado:
O arquivo de log deve ser lido e algumas estat�sticas devem ser coletadas, conforme indicado abaixo:

		� Tarefa 1: Contar e mostrar o n�mero de visitas distintas. Uma visita distinta � o conjunto de 
		todos os
	acessos provenientes de um �nico endere�o IP, com menos de 30 minutos de intervalo entre cada acesso
	consecutivo para esse IP. Ou seja, o seguinte trecho de log abaixo mostra tr�s diferentes visitas:
			
			207.46.199.54 - [ 26/Ago/2015 : 14:00:14 -0300 ]
			65.52.108.58 - [ 26/Ago/2015 : 14:08:44 -0300 ]
			207.46.199.54 - [ 26/Ago/2015 : 14:27:03 -0300 ]
			77.88.31.247 - [ 26/Ago/2015 : 14:28:26 -0300 ]
			77.88.31.247 - [ 26/Ago/2015 : 14:58:29 -0300 ]
		
		
		
		� Tarefa 2: Criar um ranking indicando os cinco navegadores (MSIE, Mozilla, etc) mais 
		utilizados para
	acessar o servidor web, classificados em ordem decrescente de ocorr�ncia.
		
		� Tarefa 3: Conhe�a os tr�s maiores per�odos de tempo sem acesso ao servidor web. Mostrar os per�odos em
	ordem decrescente de tamanho.
		
		� Tarefa 4: Criar um ranking com a lista de todas as plataformas (Windows, Linux, Mac, Android, 
		etc) de
	cliente utilizadas para acessar o servidor web, classificados em ordem crescente de quantidade.
		
		� Tarefa 5: Mostrar a quantidade de largura de banda consumida por tipo de arquivo. Por exemplo, 
		somar
	todo o consumo de banda das transfer�ncias registradas de arquivos PNG. Ordenar descrescente por
	tamanho total de transfer�ncia.

Dica: Ao testar o programa, leia somente as primeiras 500 ou 1000 linhas do arquivo para que ele possa
terminar rapidamente. Voc� pode usar as seguintes classes Java para extrair e analisar as informa��es
relevantes: String.split (), SimpleDateFormat e Date.getTime ().