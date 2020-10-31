package gr.codehub.teamOne.resource;

import gr.codehub.teamOne.exceptions.BadEntityException;
import gr.codehub.teamOne.exceptions.NotFoundException;
import gr.codehub.teamOne.representation.MeasurementDeleteDTO;
import gr.codehub.teamOne.representation.MeasurementDTO;
import gr.codehub.teamOne.representation.MeasurementsSearchParamDTO;
import org.restlet.resource.*;

import java.util.List;

public interface MeasurementResource {

    @Delete
    String deleteMeasurement(MeasurementDeleteDTO measurementDeleteDTO) throws NotFoundException, BadEntityException;

    @Put("json")
    MeasurementDTO updateMeasurement(MeasurementDTO measurementDTO)
            throws NotFoundException, BadEntityException;

    @Post("json")
    String addMeasurement(MeasurementDTO measurementDTO)
            throws NotFoundException, BadEntityException;

    @Patch("json")
    List<MeasurementDTO> getAllMeasurementsBasedOn(MeasurementsSearchParamDTO paramDTO) throws NotFoundException, BadEntityException;
}

