package com.dkorniichuk.imarket.dao.util;

import org.springframework.stereotype.Component;

@Component
public class SqlSearchQueryGenerator {
    public String generateQuery(String parameter){
        return "SELECT * FROM IMarket.product WHERE lower(product_name) like \"%?"+parameter
                +"%\" or id_product like \"%"+parameter
                +"%\" or product_description like \"%"+parameter+"%\"";
    }
}
