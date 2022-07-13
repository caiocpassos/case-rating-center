aws --endpoint-url="http://localhost:4566" dynamodb put-item \
    --table-name Average  \
    --item \
        '{"merchantId": {"S": "789"}, "lastUpdate": {"N": "1234567"}, "rateQuantity": {"N": "12"}, "average": {"N": "122"}}'
