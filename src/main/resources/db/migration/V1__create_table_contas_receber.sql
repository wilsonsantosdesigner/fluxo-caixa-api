CREATE TABLE tb_contas_receber (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   descricao VARCHAR(120) NOT NULL,
                                   valor_receber DECIMAL(10,2) NOT NULL,

                                   data_vencimento DATE NOT NULL,
                                   data_recebimento DATETIME,

                                   valor_recebido DECIMAL(10,2) DEFAULT 0.00
);