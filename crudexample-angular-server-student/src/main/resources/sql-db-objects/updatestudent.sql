DROP FUNCTION IF EXISTS public.updatestudent(json,bigint,json);

CREATE OR REPLACE FUNCTION public.updatestudent(IN v_student json,IN v_student_id bigint,IN v_address json)
    RETURNS character varying
    LANGUAGE 'plpgsql'
    VOLATILE
    PARALLEL UNSAFE
    COST 100
    
AS $BODY$
begin

update student set
	first_name = v_student ->> 'firstName',
	last_name = v_student ->> 'lastName',
	email_id = v_student ->> 'emailId',
	school_name = v_student ->> 'schoolName'
WHERE student_id = v_student_id;

update address set
	city = v_address ->> 'city',
	street = v_address ->> 'street',
	state = v_address ->> 'state',
	country = v_address ->> 'country',
	zip_code = (v_address ->> 'zipCode')::bigint
WHERE student_id = v_student_id;

return 'success';
end;
$BODY$;