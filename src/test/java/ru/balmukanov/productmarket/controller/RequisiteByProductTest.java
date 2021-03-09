package ru.balmukanov.productmarket.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.balmukanov.productmarket.constant.ProductType;
import ru.balmukanov.productmarket.dto.RequisiteDto;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.entity.Requisite;
import ru.balmukanov.productmarket.mapper.ProductMapperUser;
import ru.balmukanov.productmarket.mapper.RequisiteMapper;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarket.service.RequisiteService;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserProductController.class)
public class RequisiteByProductTest {

    @MockBean
    private ProductMapperUser productMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private RequisiteService requisiteService;

    @MockBean
    private RequisiteMapper requisiteMapper;

    @Test
    public void getRequisiteByProductId() throws Exception {
        long userId = 1;
        long productId = 1;
        long requisiteId = 1;

        Product product = new Product();
        product.setUserId(userId);
        product.setExternalId("test-guid");
        product.setAgreementId("1111");
        product.setName("Card");
        product.setType(ProductType.CARD);

        Requisite requisite = new Requisite();
        requisite.setBankName("OOO Bank name");
        requisite.setBIC("044525711");
        requisite.setCorrespondentAccount("2252525252525");
        requisite.setINN("545454455");
        requisite.setKPP("5455455");
        requisite.setRecipient("IVANOV IVAN IVANOVICH");
        requisite.setRecipientAccount("56465616");
        requisite.setProduct(product);

        product.setRequisite(requisite);

        given(requisiteService.productRequisite(productId)).willReturn(requisite);

        RequisiteDto requisiteDto = new RequisiteDto(
                requisiteId,
                requisite.getBIC(),
                requisite.getBankName(),
                requisite.getINN(),
                requisite.getKPP(),
                requisite.getRecipientAccount(),
                requisite.getRecipient(),
                requisite.getCorrespondentAccount(),
                productId
        );
        given(requisiteMapper.toDto(requisite)).willReturn(requisiteDto);

        mvc.perform(get("/product/requisites/" + productId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int)requisiteDto.id)))
                .andExpect(jsonPath("$.BIC", is(requisiteDto.BIC)))
                .andExpect(jsonPath("$.bankName", is(requisiteDto.bankName)))
                .andExpect(jsonPath("$.INN", is(requisiteDto.INN)))
                .andExpect(jsonPath("$.KPP", is(requisiteDto.KPP)))
                .andExpect(jsonPath("$.recipientAccount", is(requisiteDto.recipientAccount)))
                .andExpect(jsonPath("$.recipient", is(requisiteDto.recipient)))
                .andExpect(jsonPath("$.correspondentAccount", is(requisiteDto.correspondentAccount)))
                .andExpect(jsonPath("$.productId", is((int)requisiteDto.productId)))
                .andReturn();
    }
}
