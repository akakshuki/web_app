package c1808g1.Models.CauHinh;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class HolidayDTO{
    private int id;
	private String name_holiday;
    private Date date_off;
    public HolidayDTO(int id, String name_holiday,Date date_off) {
        super();
        this.id=id;
        this.name_holiday=name_holiday;
        this.date_off=date_off;
    }
    public HolidayDTO() {
        super();
    }
}
