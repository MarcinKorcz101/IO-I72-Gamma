import { Container, Row, Col } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';

function Functions({buildingId, setMarkedRoom}) {

    const [data, setData] = useState({id:'',func:'area', threshold:''});
    const [metric, setMetric] = useState("m2");
    const [response, setResponse] = useState(0.0);

    function handleSetData(e){
        setData({...data, [e.target.name]: e.target.value});
        if(e.target.name === 'func'){
            if(e.target.value === 'area') setMetric("m^2");
            if(e.target.value === 'cube') setMetric("m^3");
            if(e.target.value === 'heating') setMetric("gJ");
            if(e.target.value === 'light') setMetric("lx");
            if(e.target.value === 'ExceededHeating') setMetric("MARK");
            setResponse(0);
            setMarkedRoom([]);

        }
    }

    async function getData() {
        console.log(data);
        try {
            if(data.func === 'ExceededHeating'){
                const response = await axios.get(
                    `http://localhost:8080/${data.func}/${buildingId}/${data.threshold}`
                    );
                setMarkedRoom(response.data.ids);

            }else{
                const response = await axios.get(
                `http://localhost:8080/${data.func}/${data.id}`
                );
                setResponse(response.data[data.func]);
            }
           
        } catch (error) {
        }
    }

    function handleSubmit(e){
        e.preventDefault();
        getData();
    }


  return (
    <div className='functions-container'>
        <form onSubmit={(e)=>handleSubmit(e)}>
        <Container>
            <Row>
                <Col md={4}> <h5>Function:</h5></Col>
                <Col md={8}> 
                <select className='select-function' required name='func' onChange={(e)=>(handleSetData(e))}>
                    <option value='area'>getArea</option>
                    <option value='cube'>getCube</option>
                    <option value='heating'>getHeating</option>
                    <option value='light'>getLight</option>
                    <option value='ExceededHeating'>markExceededHeating</option>
                </select>
                </Col>
            </Row>
           
            
        </Container>
        <Container className='center' style={{paddingBottom:'10px'}}>
        <hr/>
        {data.func !== "ExceededHeating" ? <>
           <span className='bold-span'>Id: </span>
            <input type='number' step='1' required name='id' value={data.id} className='input-id' onChange={(e)=>(handleSetData(e))}/>
            </>:
            <>
                <span className='bold-span'>Threshold: </span>
                <input type='number' step='1' required name='threshold' value={data.threshold} className='input-id' onChange={(e)=>(handleSetData(e))}/>
            </>
            }
          <input type='submit' value='Get' className='button-func'/>

          {data.func === "ExceededHeating" ? <div className='response-div'>{metric}</div> 
                                            : <div className='response-div'> = {response} {metric}</div>}
        </Container>
        </form>
    </div>
    );
}   

export default Functions;
