package ru.balmukanov.productmarket.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.balmukanov.productmarket.controller.UserProductController;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.mapper.ProductMapper;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductType;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserProductController.class)
public class ProductUserListTest {

    @MockBean
    private ProductMapper productMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductList() throws Exception {
        long userId = 1;
        long productId = 1;

        Product product = new Product();
        product.setUserId(userId);
        product.setExternalId("test-guid");
        product.setAgreementId("1111");
        product.setName("Card");
        product.setType(ProductType.CARD);
        List<Product> allProducts = Collections.singletonList(product);

        given(productService.userList(productId)).willReturn(allProducts);

        ProductDto productDto = new ProductDto(
                productId,
                product.getExternalId(),
                product.getName(),
                product.getType(),
                product.getAgreementId(),
                product.getUserId()
        );
        List<ProductDto> allProductsDto = Collections.singletonList(productDto);

        given(productMapper.toDtoList(allProducts)).willReturn(allProductsDto);

        mvc.perform(get("/product/user/" + userId + "/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is((int)productDto.id)))
                .andExpect(jsonPath("$[0].name", is(productDto.name)))
                .andExpect(jsonPath("$[0].externalId", is(productDto.externalId)))
                .andExpect(jsonPath("$[0].type", is(productDto.type.toString())))
                .andExpect(jsonPath("$[0].agreementId", is(productDto.agreementId)))
                .andExpect(jsonPath("$[0].userId", is((int)productDto.userId)))
                .andReturn();
    }
}
