docker-compose exec -T mysql.monolito mysqldump -uroot -pcaelum123 --opt eats_pagamento | docker-compose exec -T mysql.pagamento mysql -upagamento -ppagamento123 eats_pagamento
