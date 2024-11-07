package info.techsploit.BankingApp.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class AccountRequest {

    private String accountHolderName;
    private double balance;
}
