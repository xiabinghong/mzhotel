package com.mzhotel.personalReservation.controller;

import com.mzhotel.personalReservation.dto.PersonalReservation;
import com.mzhotel.personalReservation.service.PersonalReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/personalReservation")
public class PersonalReservationController {
    
    @Autowired
    PersonalReservationService personalReservationService;

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id){
        return personalReservationService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid PersonalReservation record){
        return personalReservationService.insert(record);
    }

    @RequestMapping(value="/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid PersonalReservation record){
        return personalReservationService.insertSelective(record);
    }

    @RequestMapping(value="/selectByPrimaryKey",method = RequestMethod.GET)
    public PersonalReservation selectByPrimaryKey(@PathVariable(value = "id") String id){
        return personalReservationService.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid PersonalReservation record){
        return personalReservationService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/updateByPrimaryKey",method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid PersonalReservation record){
        return personalReservationService.updateByPrimaryKey(record);
    }
    
}
