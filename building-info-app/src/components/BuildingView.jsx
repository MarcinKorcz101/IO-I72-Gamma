import { Container } from 'react-bootstrap';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Level from './Level';
import Functions from './Functions';

function BuildingView() {

    const [data, setData] = useState({});
    const [isLoading, setIsLoading] = useState(true);
    const [markedRoom, setMarkedRoom] = useState([]);

    async function getData() {
        try {
            const response = await axios.get(
            `http://localhost:8080/`
            );
            setData(response.data);
            setIsLoading(false);
            console.log(response.data);
        } catch (error) {
        }
    }

    useEffect(() => {
        getData();
    }, []);




  return (
    <>
        {!isLoading && 
        <Container className='building-container'>
            
            <Container fluid className='building-name'>
                <Container><h3>Building:</h3></Container>
                <hr className='section-hr'/>
                <Container><h5>Name: {data.name} (#{data.id})</h5></Container>
            </Container>
            <hr/>
            {data.levels.map((level)=>
                <Level key={level.id} level={level} markedRoom={markedRoom}/>
            )}
        </Container>
        }
        <Functions buildingId={data.id} setMarkedRoom={setMarkedRoom} />
    </>
    );
}   

export default BuildingView;
