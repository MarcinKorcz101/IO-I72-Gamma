import { Container, Row } from 'react-bootstrap';
import Room from './Room';



function Level({level, markedRoom}) {
  return (
        <Container className='level-container'>
            <Container fluid className='level-name'>
                <Container><h4>Level:</h4></Container>
                <hr className='section-hr'/>
                <Container><h5>Name: {level.name} (#{level.id})</h5></Container>
            </Container>
            <Container>
                <Row>
                    {level.rooms.map((room)=>
                    <Room key={room.id} room={room} isMarked={markedRoom.some((id) => (id === room.id))}/>
                    )}
                </Row>
            </Container>
            <hr />
        </Container>
 
    );
}   

export default Level;
