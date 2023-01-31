package com.system.kinmel.pojo;

import com.system.kinmel.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPojo {
    private Integer id;
    private String categoryName;

    public CategoryPojo(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
    }
}
