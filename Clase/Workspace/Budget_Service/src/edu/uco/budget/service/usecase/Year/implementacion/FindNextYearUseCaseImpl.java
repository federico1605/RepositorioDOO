package edu.uco.budget.service.usecase.Year.implementacion;

import java.util.List;

import edu.uco.budget.crosscutting.helper.DateHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.Year.FinfNextYearUsecase;

public class FindNextYearUseCaseImpl implements FinfNextYearUsecase{

    private final DAOFactory factory;

    public FindNextYearUseCaseImpl(DAOFactory factory){
        this.factory = factory;
    }

    @Override
    public YearDTO execute() {
        YearDTO year = YearDTO.create("", DateHelper.getNextYear());
        final List<YearDTO> result = factory.getYearDAO().find(year);

        if(result.isEmpty()){
            year.setId(UUIDHelper.getNewUUID());
            factory.getYearDAO().create(year);
        } else {
            year = result.get(0);
        }

        return year;
    }
}
