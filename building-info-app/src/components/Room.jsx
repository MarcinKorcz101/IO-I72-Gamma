import { Container, Col } from 'react-bootstrap';


function Room({room, isMarked}) {
  return (
      <Col md={3}>
        <Container className={`room-container ${isMarked && 'marked'}`}>
            <h5>Room:</h5>
            <hr/>
            <Container> <span className='bold-span'>Id: </span>#{room.id} </Container>

            <Container> <span className='bold-span'>Name:</span> {room.name} </Container>
            <Container > <span className='bold-span'>Area:</span> {room.area} m^2 </Container>
            <Container > <span className='bold-span'>Cube:</span> {room.cube} m^3</Container>
            <Container > <span className='bold-span'>Heating:</span> {room.heating} gJ </Container>
            <Container> <span className='bold-span'>Light:</span> {room.light} lx</Container>
        </Container>
    </Col>
    );
}   

export default Room;
