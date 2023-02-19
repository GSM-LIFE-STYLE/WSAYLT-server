package lifestyle.WSAYLT.domain.board.entity;


 import lifestyle.WSAYLT.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id", nullable = false)
    private Long boardId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "music_url",nullable = false)
    private String musicUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
