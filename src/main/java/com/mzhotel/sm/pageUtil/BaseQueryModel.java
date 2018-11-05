package com.mzhotel.sm.pageUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

@Data
public class BaseQueryModel implements Serializable {

    private String orderBy;

    private String[] sorts;

    private Integer pageSize;

    private Integer pageNum;

    public void setSorts(String[] sorts) {
        this.sorts = sorts;
        if (sorts != null && sorts.length > 0) {
            if (orderBy == null) {
                List<String> order = Lists.newArrayList();
                for (int i = 0; i < sorts.length; i++) {
                    String sort = sorts[i];
                    if (sort.startsWith("-") && sort.endsWith("@date")) {
                        String[] orderSort = sort.substring(1, sort.length()).split("@");
                        order.add(MessageFormat.format("{0} DESC", orderSort[0]));
                    } else if (sort.startsWith("-")) {
                        order.add(MessageFormat.format("NLSSORT({0},''NLS_SORT=SCHINESE_PINYIN_M'') DESC", sort.substring(1, sort.length())));
                    } else if (sort.endsWith("@date")) {
                        String[] orderSort = sort.split("@");
                        order.add(orderSort[0]);
                    } else {
                        order.add(MessageFormat.format("NLSSORT({0},''NLS_SORT=SCHINESE_PINYIN_M'')", sort));
                    }
                }
                this.orderBy = Joiner.on(",").join(order);
            }
        }
    }
}
