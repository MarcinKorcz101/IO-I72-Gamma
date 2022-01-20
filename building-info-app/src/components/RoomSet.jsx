import { Container, Col, Row } from 'react-bootstrap';


function RoomSet({room, deleteRoom, levelKey, handleData, canDelete}) {
  return (
      <Col md={3}>
        <Container className='room-container'>
                <Row>
                    <Col md={9}>
                    <h4>Room:</h4>
                    </Col>
                    <Col md={3}> <div onClick={()=>(canDelete && deleteRoom(levelKey, room.key))} className='delete-button room-delete'> - </div></Col>
                </Row>
            <hr/>
            <Container className='room-set-row'>
                <Row>
                    <Col md={4}> Id: </Col>
                    
                    <Col md={8}> <input className='input-id' 
                                        type='number'
                                        step='1'
                                        name='id' 
                                        value={room.id} 
                                        onChange={(e)=>(handleData(e, levelKey, room.key))}
                                        required/>
                        </Col>
                    
                </Row>
            </Container>
            <Container className='room-set-row'>
                <Row>
                    <Col md={4}> Name: </Col>
                    <Col md={8}>
                
                        <input
                            className='input-name'
                            name='name' 
                            value={room.name} 
                            onChange={(e)=>(handleData(e, levelKey, room.key))}
                            required/> 
                    </Col>
                </Row>
            </Container>

            <Container className='room-set-row'>
                <Row>
                    <Col md={4}> Area:</Col>
                    <Col md={8}>
                <input
                                            className='input-id'
                                            type='number'
                                            step='1'
                                            name='area' 
                                            value={room.area} 
                                            onChange={(e)=>(handleData(e, levelKey, room.key))}
                                            required/> m^2
                    </Col>
                </Row>
            </Container >

            <Container className='room-set-row'>
                <Row>
                        <Col md={4}> Cube:</Col>
                        <Col md={8}>
                <input
                        className='input-id'
                        type='number'
                        step='1'
                        name='cube' 
                        value={room.cube} 
                        onChange={(e)=>(handleData(e, levelKey, room.key))}
                        required/> m^3
                </Col>
                </Row>
            </Container>

            <Container className='room-set-row'>
            <Row>
                        <Col md={4}>  Heating: </Col>
                        <Col md={8}>
                
              <input
                                            className='input-id'
                                            type='number'
                                            step='1'
                                            name='heating' 
                                            value={room.heating} 
                                            onChange={(e)=>(handleData(e, levelKey, room.key))}
                                            required/> gJ
                    </Col>
                </Row>
            </Container>

             <Container className='room-set-row'>
                 
             <Row>
                        <Col md={4}> Light: </Col>
                        <Col md={8}>
                         <input
                        className='input-id'
                        type='number'
                        step='1'
                        name='light' 
                        value={room.light} 
                        onChange={(e)=>(handleData(e, levelKey, room.key))}
                        required/>  jx
                        </Col>
                </Row>
            </Container>
        </Container>
    </Col>
    );
}   

export default RoomSet;
