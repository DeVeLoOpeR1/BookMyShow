package com.example.BookMyShow.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketRequest {

    private int showId;
    private int userId;
    private List<String> showSeatList = new ArrayList<>();

}
