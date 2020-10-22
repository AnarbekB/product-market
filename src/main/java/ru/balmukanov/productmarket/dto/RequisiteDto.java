package ru.balmukanov.productmarket.dto;

public class RequisiteDto {
    public long id;

    public String BIC;

    public String bankName;

    public String INN;

    public String KPP;

    public String recipientAccount;

    public String recipient;

    public String correspondentAccount;

    public long productId;

    public RequisiteDto(
            Long id,String BIC, String bankName, String INN,
            String KPP, String recipientAccount, String recipient,
            String correspondentAccount, long productId
    ) {
        this.id = id;
        this.BIC = BIC;
        this.bankName = bankName;
        this.INN = INN;
        this.KPP = KPP;
        this.recipientAccount = recipientAccount;
        this.recipient = recipient;
        this.correspondentAccount = correspondentAccount;
        this.productId = productId;
    }
}
