package info.techsploit.BankingApp.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class APIResponse {

    private int errorCode;
    private String errorMessage;
    private Object data;
}
