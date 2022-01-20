import { Col, Container, Row } from 'react-bootstrap';
import RoomSet from './RoomSet';



function LevelSet({level, addRoom, deleteLevel, deleteRoom, handleData, canDelete}) {
  return (
        <Container className='level-container'>
            <Container fluid className='level-name'>
                <Container><h3>Level:</h3></Container>
                <hr className='section-hr'/>
                <Container>
                    <Row>
                        <Col md={4}>Name: <input  required name='name' value={level.name} onChange={(e)=>(handleData(e, level.key, null))}/></Col>
                        <Col md={4}>Id: <input required type='number' name='id' value={level.id} onChange={(e)=>(handleData(e, level.key, null))}/></Col>
                        <Col md={2} className='center'>
                            <div className='add-button'  onClick={()=>(addRoom(level.key))}>+ Add room</div>
                        </Col>
                        <Col md={2} className='center'>
                            <div className='delete-button'  onClick={()=>( canDelete && deleteLevel(level.key))}> - Delete level</div>
                        </Col>
                    </Row>
                </Container>
            </Container>
            <Container>
                <Row>
                    {level.rooms.map((room)=>
                    <RoomSet 
                            key={`${room.key}${level.key}`} 
                            room={room} 
                            deleteRoom={deleteRoom} 
                            levelKey={level.key} 
                            handleData={handleData}
                            canDelete={level.rooms.length > 1}/>
                    )}
                </Row>
            </Container>
            <hr />
        </Container>
 
    );
}   

export default LevelSet;
