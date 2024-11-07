package info.techsploit.BankingApp.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class AccountResponse {
    private Long id;
    private String accountHolderName;
    private double balance;

}
