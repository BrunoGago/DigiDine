     import json
     import requests

     def lambda_handler(event, context):
         cpf = event.get('cpf')
         response = requests.get(f'http://your-java-service-url/api/customers/authenticate?cpf={cpf}')
         
         if response.status_code == 200:
             return {
                 'statusCode': 200,
                 'body': json.dumps('Authenticated')
             }
         else:
             return {
                 'statusCode': 401,
                 'body': json.dumps('Authentication Failed')
             }