package ee.camping.back_camping.domain.listing.location;

import ee.camping.back_camping.business.dto.CountyDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T11:45:45+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class CountyMapperImpl implements CountyMapper {

    @Override
    public CountyDto toCountyDto(County county) {
        if ( county == null ) {
            return null;
        }

        CountyDto countyDto = new CountyDto();

        countyDto.setCountyId( county.getId() );
        countyDto.setCountyName( county.getName() );

        return countyDto;
    }

    @Override
    public List<CountyDto> toCountyDtos(List<County> allCounties) {
        if ( allCounties == null ) {
            return null;
        }

        List<CountyDto> list = new ArrayList<CountyDto>( allCounties.size() );
        for ( County county : allCounties ) {
            list.add( toCountyDto( county ) );
        }

        return list;
    }
}
